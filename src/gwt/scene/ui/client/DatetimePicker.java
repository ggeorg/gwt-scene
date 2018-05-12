package gwt.scene.ui.client;

import java.util.Date;
import java.util.Objects;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsDate;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HasValue;

public class DatetimePicker extends Widget implements HasValue<Date> {

	private static DatetimePickerUiBinder uiBinder = GWT.create(DatetimePickerUiBinder.class);

	interface DatetimePickerUiBinder extends UiBinder<DivElement, DatetimePicker> {
	}

	private JavaScriptObject datetimepicker = null;

	public DatetimePicker() {
		setElement(uiBinder.createAndBindUi(this));
		datetimepicker = initDatetimePicker(getElement());

		setValue(new Date());
	}

	private native JavaScriptObject initDatetimePicker(Element element) /*-{
		var locale = $wnd.navigator.userLanguage || $wnd.navigator.language;
		$wnd.moment.locale(locale);

		return $wnd.jQuery(element).datetimepicker({
			format : 'L'
		});
	}-*/;

	private native void destroy(JavaScriptObject datetimepicker) /*-{
		datetimepicker.data("DateTimePicker").destroy();
	}-*/;

	private HandlerRegistration onChangeHR = null;

	@Override
	protected void onLoad() {
		onChangeHR = onChange(this, datetimepicker, new OnChangeHandler() {
			@Override
			public void onChange(JsDate newDate) {
				ValueChangeEvent.fire(DatetimePicker.this, new Date((long) newDate.getTime()));
			}
		});
	}

	static interface OnChangeHandler {
		void onChange(JsDate newDate);
	}

	static class OnChangeHandlerRegistration extends JavaScriptObject implements HandlerRegistration {
		protected OnChangeHandlerRegistration() {
		}

		@Override
		public final native void removeHandler() /*-{
			this.remove();
		}-*/;
	}

	private static native OnChangeHandlerRegistration onChange(DatetimePicker datetimePicker,
			JavaScriptObject datetimepicker, OnChangeHandler handler) /*-{
		var fcn = function(e) {
			handler.@gwt.scene.ui.client.DatetimePicker.OnChangeHandler::onChange(Lcom/google/gwt/core/client/JsDate;)((!!e.date ? e.date.toDate() : null));
		}
		
		datetimepicker.on('dp.change', fcn);
		
		return {
			remove : function() {
				datetimepicker.off('dp.change', fcn);
			}
		};
	}-*/;

	@Override
	protected void onUnload() {
		if (onChangeHR != null) {
			onChangeHR.removeHandler();
			onChangeHR = null;
		}
	}

	public void setMinDate(Date date) {
		setMinDate(datetimepicker, JsDate.create(date.getTime()));
	}

	private static native void setMinDate(JavaScriptObject datetimepicker, JsDate date) /*-{
		datetimepicker.data("DateTimePicker").minDate(date);
	}-*/;

	public void setMaxDate(Date date) {
		setMaxDate(datetimepicker, JsDate.create(date.getTime()));
	}

	private static native void setMaxDate(JavaScriptObject datetimepicker, JsDate date) /*-{
		datetimepicker.data("DateTimePicker").maxDate(date);
	}-*/;

	@Override
	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Date> handler) {
		return addHandler(handler, ValueChangeEvent.getType());
	}

	@Override
	public Date getValue() {
		JsDate value = getValue(datetimepicker);
		return (value != null) ? new Date((long) value.getTime()) : null;
	}

	private static native JsDate getValue(JavaScriptObject datetimepicker) /*-{
		return datetimepicker.data("DateTimePicker").date();
	}-*/;

	@Override
	public void setValue(Date value) {
		setValue(value, true);
	}

	@Override
	public void setValue(Date value, boolean fireEvents) {
		Date oldValue = getValue();
		if (!Objects.equals(oldValue, value)) {
			try {
				setValue(datetimepicker, value != null ? JsDate.create(value.getTime()) : null);
			} catch (RuntimeException e) {
				throw new IllegalArgumentException(e.getMessage());
			}
		}
	}

	private native void setValue(JavaScriptObject datetimepicker, JsDate value) /*-{
		datetimepicker.data("DateTimePicker").date($wnd.moment(value));
	}-*/;
}
