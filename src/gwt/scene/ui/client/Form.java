package gwt.scene.ui.client;

import java.util.Iterator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.FormElement;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.annotations.IsSafeHtml;
import com.google.gwt.safehtml.shared.annotations.IsSafeUri;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.NamedFrame;
import com.google.gwt.user.client.ui.ProvidesResize;
import com.google.gwt.user.client.ui.RequiresResize;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.impl.FormPanelImpl;
import com.google.gwt.user.client.ui.impl.FormPanelImplHost;

import gwt.scene.core.client.DOM;

@SuppressWarnings("deprecation")
public class Form extends HTMLPanel 
	implements SceneNode, FormPanelImplHost, RequiresResize, ProvidesResize {

	/**
	 * Fired when a form has been submitted successfully.
	 */
	public static class SubmitCompleteEvent extends GwtEvent<SubmitCompleteHandler> {
		/**
		 * The event type.
		 */
		private static Type<SubmitCompleteHandler> TYPE;

		/**
		 * Handler hook.
		 *
		 * @return the handler hook
		 */
		public static Type<SubmitCompleteHandler> getType() {
			if (TYPE == null) {
				TYPE = new Type<SubmitCompleteHandler>();
			}
			return TYPE;
		}

		private String resultHtml;

		/**
		 * Create a submit complete event.
		 *
		 * @param resultsHtml
		 *            the results from submitting the form
		 */
		protected SubmitCompleteEvent(String resultsHtml) {
			this.resultHtml = resultsHtml;
		}

		@Override
		public final Type<SubmitCompleteHandler> getAssociatedType() {
			return getType();
		}

		/**
		 * Gets the result text of the form submission.
		 *
		 * @return the result html, or <code>null</code> if there was an error reading
		 *         it
		 * @tip The result html can be <code>null</code> as a result of submitting a
		 *      form to a different domain.
		 */
		public String getResults() {
			return resultHtml;
		}

		@Override
		protected void dispatch(SubmitCompleteHandler handler) {
			handler.onSubmitComplete(this);
		}
	}

	/**
	 * Handler for {@link Form.SubmitCompleteEvent} events.
	 */
	public interface SubmitCompleteHandler extends EventHandler {
		/**
		 * Fired when a form has been submitted successfully.
		 *
		 * @param event
		 *            the event
		 */
		void onSubmitComplete(Form.SubmitCompleteEvent event);
	}

	/**
	 * Fired when the form is submitted.
	 */
	public static class SubmitEvent extends GwtEvent<SubmitHandler> {
		/**
		 * The event type.
		 */
		private static Type<SubmitHandler> TYPE;

		/**
		 * Handler hook.
		 *
		 * @return the handler hook
		 */
		public static Type<SubmitHandler> getType() {
			if (TYPE == null) {
				TYPE = new Type<SubmitHandler>();
			}
			return TYPE;
		}

		private boolean canceled = false;

		/**
		 * Cancel the form submit. Firing this will prevent a subsequent
		 * {@link Form.SubmitCompleteEvent} from being fired.
		 */
		public void cancel() {
			this.canceled = true;
		}

		@Override
		public final Type<Form.SubmitHandler> getAssociatedType() {
			return getType();
		}

		/**
		 * Gets whether this form submit will be canceled.
		 *
		 * @return <code>true</code> if the form submit will be canceled
		 */
		public boolean isCanceled() {
			return canceled;
		}

		@Override
		protected void dispatch(Form.SubmitHandler handler) {
			handler.onSubmit(this);
		}

		/**
		 * This method is used for legacy support and should be removed when
		 * {@link FormHandler} is removed.
		 *
		 * @deprecated Use {@link Form.SubmitEvent#cancel()} instead
		 */
		@Deprecated
		void setCanceled(boolean canceled) {
			this.canceled = canceled;
		}
	}

	/**
	 * Handler for {@link Form.SubmitEvent} events.
	 */
	public interface SubmitHandler extends EventHandler {
		/**
		 * Fired when the form is submitted.
		 *
		 * <p>
		 * The Form must <em>not</em> be detached (i.e. removed from its parent or
		 * otherwise disconnected from a {@link RootPanel}) until the submission is
		 * complete. Otherwise, notification of submission will fail.
		 * </p>
		 *
		 * @param event
		 *            the event
		 */
		void onSubmit(Form.SubmitEvent event);
	}

	/**
	 * Used with {@link #setEncoding(String)} to specify that the form will be
	 * submitted using MIME encoding (necessary for {@link FileUpload} to work
	 * properly).
	 */
	public static final String ENCODING_MULTIPART = "multipart/form-data";

	/**
	 * Used with {@link #setEncoding(String)} to specify that the form will be
	 * submitted using traditional URL encoding.
	 */
	public static final String ENCODING_URLENCODED = "application/x-www-form-urlencoded";

	/**
	 * Used with {@link #setMethod(String)} to specify that the form will be
	 * submitted using an HTTP GET request.
	 */
	public static final String METHOD_GET = "get";

	/**
	 * Used with {@link #setMethod(String)} to specify that the form will be
	 * submitted using an HTTP POST request (necessary for {@link FileUpload} to
	 * work properly).
	 */
	public static final String METHOD_POST = "post";

	private static int formId = 0;
	private static FormPanelImpl impl = GWT.create(FormPanelImpl.class);

	interface IFrameTemplate extends SafeHtmlTemplates {
		static final IFrameTemplate INSTANCE = GWT.create(IFrameTemplate.class);

		@Template("<iframe src=\"about:blank\" name='{0}' tabindex='-1' "
				+ "style='position:absolute;width:0;height:0;border:0'>")
		SafeHtml get(String name);
	}

	private String frameName;
	private Element synthesizedFrame;

	public Form() {
		this("", true);
	}

	public Form(@IsSafeHtml String html) {
		this(html, true);
	}

	private Form(@IsSafeHtml String html, boolean createIFrame) {
		super("form", html);

		if (createIFrame) {
			// We use the module name as part of the unique ID to ensure that ids are
			// unique across modules.
			frameName = "Form_" + GWT.getModuleName() + "_" + (++formId);
			setTarget(frameName);
		}
	}

	/**
	 * Adds a {@link SubmitCompleteEvent} handler.
	 *
	 * @param handler
	 *            the handler
	 * @return the handler registration used to remove the handler
	 */
	public HandlerRegistration addSubmitCompleteHandler(SubmitCompleteHandler handler) {
		return addHandler(handler, SubmitCompleteEvent.getType());
	}

	/**
	 * Adds a {@link SubmitEvent} handler.
	 *
	 * @param handler
	 *            the handler
	 * @return the handler registration used to remove the handler
	 */
	public HandlerRegistration addSubmitHandler(SubmitHandler handler) {
		return addHandler(handler, SubmitEvent.getType());
	}

	/**
	 * Gets the 'action' associated with this form. This is the URL to which it will
	 * be submitted.
	 *
	 * @return the form's action
	 */
	public String getAction() {
		return getFormElement().getAction();
	}

	/**
	 * Gets the encoding used for submitting this form. This should be either
	 * {@link #ENCODING_MULTIPART} or {@link #ENCODING_URLENCODED}.
	 *
	 * @return the form's encoding
	 */
	public String getEncoding() {
		return impl.getEncoding(getElement());
	}

	/**
	 * Gets the HTTP method used for submitting this form. This should be either
	 * {@link #METHOD_GET} or {@link #METHOD_POST}.
	 *
	 * @return the form's method
	 */
	public String getMethod() {
		return getFormElement().getMethod();
	}

	/**
	 * Gets the form's 'target'. This is the name of the {@link NamedFrame} that
	 * will receive the results of submission, or <code>null</code> if none has been
	 * specified.
	 *
	 * @return the form's target.
	 */
	public String getTarget() {
		return getFormElement().getTarget();
	}

	/**
	 * Fired when a form is submitted.
	 *
	 * @return true if the form is submitted, false if canceled
	 */
	@Override
	public boolean onFormSubmit() {
		return onFormSubmitImpl();
	}

	@Override
	public void onFrameLoad() {
		onFrameLoadImpl();
	}

	/**
	 * Resets the form, clearing all fields.
	 */
	public void reset() {
		impl.reset(getElement());
	}

	/**
	 * Sets the 'action' associated with this form. This is the URL to which it will
	 * be submitted.
	 *
	 * @param url
	 *            the form's action
	 */
	public void setAction(@IsSafeUri String url) {
		getFormElement().setAction(url);
	}

	/**
	 * Sets the encoding used for submitting this form. This should be either
	 * {@link #ENCODING_MULTIPART} or {@link #ENCODING_URLENCODED}.
	 *
	 * @param encodingType
	 *            the form's encoding
	 */
	public void setEncoding(String encodingType) {
		impl.setEncoding(getElement(), encodingType);
	}

	/**
	 * Sets the HTTP method used for submitting this form. This should be either
	 * {@link #METHOD_GET} or {@link #METHOD_POST}.
	 *
	 * @param method
	 *            the form's method
	 */
	public void setMethod(String method) {
		getFormElement().setMethod(method);
	}

	/**
	 * Submits the form.
	 *
	 * <p>
	 * The Form must <em>not</em> be detached (i.e. removed from its parent or
	 * otherwise disconnected from a {@link RootPanel}) until the submission is
	 * complete. Otherwise, notification of submission will fail.
	 * </p>
	 */
	public void submit() {
		// Fire the onSubmit event, because javascript's form.submit() does not
		// fire the built-in onsubmit event.
		if (!fireSubmitEvent()) {
			return;
		}

		impl.submit(getElement(), synthesizedFrame);
	}

	@Override
	protected void onAttach() {
		super.onAttach();

		if (frameName != null) {
			// Create and attach a hidden iframe to the body element.
			createFrame();
			Document.get().getBody().appendChild(synthesizedFrame);
		}
		// Hook up the underlying iframe's onLoad event when attached to the DOM.
		// Making this connection only when attached avoids memory-leak issues.
		// The Form cannot use the built-in GWT event-handling mechanism
		// because there is no standard onLoad event on iframes that works across
		// browsers.
		impl.hookEvents(synthesizedFrame, getElement(), this);
	}

	@Override
	protected void onDetach() {
		super.onDetach();

		// Unhook the iframe's onLoad when detached.
		impl.unhookEvents(synthesizedFrame, getElement());

		if (synthesizedFrame != null) {
			// And remove it from the document.
			Document.get().getBody().removeChild(synthesizedFrame);
			synthesizedFrame = null;
		}
	}

	// For unit-tests.
	Element getSynthesizedIFrame() {
		return synthesizedFrame;
	}

	private void createFrame() {
		// Attach a hidden IFrame to the form. This is the target iframe to which
		// the form will be submitted. We have to create the iframe using innerHTML,
		// because setting an iframe's 'name' property dynamically doesn't work on
		// most browsers.
		Element dummy = Document.get().createDivElement();
		dummy.setInnerSafeHtml(IFrameTemplate.INSTANCE.get(frameName));

		synthesizedFrame = dummy.getFirstChildElement();
	}

	/**
	 * Fire a {@link Form.SubmitEvent}.
	 *
	 * @return true to continue, false if canceled
	 */
	private boolean fireSubmitEvent() {
		Form.SubmitEvent event = new Form.SubmitEvent();
		fireEvent(event);
		return !event.isCanceled();
	}

	private FormElement getFormElement() {
		return getElement().cast();
	}

	/**
	 * Returns true if the form is submitted, false if canceled.
	 */
	private boolean onFormSubmitImpl() {
		return fireSubmitEvent();
	}

	private void onFrameLoadImpl() {
		// Fire onComplete events in a deferred command. This is necessary
		// because clients that detach the form panel when submission is
		// complete can cause some browsers (i.e. Mozilla) to go into an
		// 'infinite loading' state. See issue 916.
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			public void execute() {
				fireEvent(new SubmitCompleteEvent(impl.getContents(synthesizedFrame)));
			}
		});
	}

	private void setTarget(String target) {
		getFormElement().setTarget(target);
	}

	//
	// SceneNode implementation
	//

	@Override
	public String getFlex() {
		return DOM.getFlex(this);
	}

	@Override
	public void setFlex(String flex) {
		DOM.setFlex(this, flex);
	}

	@Override
	public String getMargin() {
		return DOM.getFlex(this);
	}

	@Override
	public void setMargin(String margin) {
		DOM.setMargin(this, margin);
	}

	@Override
	public String getBorder() {
		return DOM.getBorder(this);
	}

	@Override
	public void setBorder(String border) {
		DOM.setBorder(this, border);
	}

	@Override
	public String getPadding() {
		return DOM.getPadding(this);
	}

	@Override
	public void setPadding(String padding) {
		DOM.setPadding(this, padding);
	}

	@Override
	public String getBackground() {
		return DOM.getBackground(this);
	}

	@Override
	public void setBackground(String background) {
		DOM.setBackground(this, background);
	}

	//
	// RequiresResize implementation
	//

	@Override
	public void onResize() {
		for (Iterator<Widget> iter = iterator(); iter.hasNext();) {
			final Widget child = iter.next();
			if (child instanceof RequiresResize) {
				((RequiresResize) child).onResize();
			}
		}
	}
}
