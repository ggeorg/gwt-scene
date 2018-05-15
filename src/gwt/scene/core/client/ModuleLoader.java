package gwt.scene.core.client;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;

import gwt.scene.core.client.collections.JsObject;

public final class ModuleLoader {

	public static void require(final Callback<Void, Exception> callback, String... module) {
		require(JsObject.create(), callback, module);
	}

	public static void require(final JsObject config, final Callback<Void, Exception> callback, String... module) {
		ScriptInjector.fromUrl(GWT.getModuleName() + "/require.js")
				.setWindow(ScriptInjector.TOP_WINDOW)
				.setCallback(new Callback<Void, Exception>() {
					@Override
					public void onSuccess(final Void result) {
						_require(GWT.getModuleName(), config, callback, module);
					}

					@Override
					public void onFailure(final Exception e) {
						callback.onFailure(e);
					}
				}).inject();
	}

	protected static native void _require(String baseUrl,
			JsObject config, Callback<Void, Exception> callback, String[] module) /*-{
		
		// Polyfill: Array.isArray
		if (!Array.isArray) {
			Array.isArray = function(arg) {
				return Object.prototype.toString.call(arg) === '[object Array]';
			};
		}
		
		// Simple configuration object extend function.
		function _extend(obj1, obj2) {
			if (typeof obj2 === "object") {
				for (p in obj2) {
					if (!obj1.hasOwnProperty(p)) {
						obj1[p] = obj2[p];
					} else {
						var m1 = obj1[p];
						if (typeof m1 === "object" && !Array.isArray(m1)) {
							var m2 = obj2[p];
							if (typeof m2 === "object" && !Array.isArray(m2)) {
								for (m_p in m2) {
									m1[m_p] = m2[m_p];
								}
							} else {
								obj1[p] = obj2[p];
							}
						} else {
							obj1[p] = obj2[p];
						}
					}
				}
			}
			return obj1;
		}
		
		$wnd.require.config(
			_extend({
				baseUrl: baseUrl,
				paths: {
					
					//
					// Core Module
					//
					
					'jquery': 'jquery/3.3.1/jquery.min',
					'moment': 'moment/2.22.0/js/moment-with-locales.min',
					
					//
					// GL Matrix
					//
					
					'gl-matrix': 'gl-matrix/2.4.0/gl-matrix-min',
					
					//
					// UI Module
					//
					
					'popper_js': 'popper.js/1.14.1/umd/popper.min',
					'bootstrap4': 'bootstrap/4.0.0/js/bootstrap.min',
					'jquery-resizable': 'jquery-resizable/0.28/jquery-resizable',
					'bootstrap-datepicker': 'bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.min',
					'tempusdominus-core': 'tempusdominus-core/5.0.0-alpha17/js/tempusdominus-core.min',
					'tempusdominus-bootstrap-4': 'tempusdominus-bootstrap-4/5.0.0-alpha18/js/tempusdominus-bootstrap-4',
					'bootstrap4-datetimepicker': 'bootstrap4-datetimepicker/4.17.50/js/bootstrap-datetimepicker',
					
					'jquery-ui': 'jquery-ui/1.12.1/js/jquery-ui.min',
					
					//
					// NVD3 Module
					//
					
					
					'd3': 'd3/3.5.17/d3.min',
					'nvd3': 'nvd3/1.8.6/nv.d3',
					
					//
					// SlickGrid
					//
					
					'jquery.event.drag': 'SlickGrid-6pac/2.3.17/lib/jquery.event.drag-2.3.0',
					'jquery.event.drop': 'SlickGrid-6pac/2.3.17/lib/jquery.event.drop-2.3.0',
					'slick.core': 'SlickGrid-6pac/2.3.17/slick.core',
					'slick.editors': 'SlickGrid-6pac/2.3.17/slick.editors',
					'slick.formatters': 'SlickGrid-6pac/2.3.17/slick.formatters',
					'slick.grid': 'SlickGrid-6pac/2.3.17/slick.grid',
					
					//
					// DataTables Module
					//
					
					'datatables.net': 'datatables.net/1.10.16/js/jquery.dataTables.min',
					'datatables.net-bs4': 'datatables.net-bs4/3.2.2/js/dataTables.bootstrap4.min',
					'datatables.net-responsive': 'datatables.net-responsive/2.2.0/js/dataTables.responsive.min',
					'datatables.net-responsive-bs4': 'datatables.net-responsive-bs4/2.2.0/js/responsive.bootstrap4.min',
					'datatables.net-scroller': 'datatables.net-scroller/1.4.3/js/dataTables.scroller.min'
				},
				map: {
					'*': {
						'popper.js': 'popper_js'
					}
				}
			}, config || {})
		);
		$wnd.require(module, function() {
			callback.@com.google.gwt.core.client.Callback::onSuccess(Ljava/lang/Object;)(null);
		}, function(err) {
			console.error(err);
			callback.@com.google.gwt.core.client.Callback::onFailure(Ljava/lang/Object;)(@gwt.scene.core.client.ModuleLoader::createException(Ljava/lang/String;)('Loading '+JSON.stringify(err.requireModules)+' failed.'))
		});
	}-*/;

	private static Exception createException(String message) {
		return new RuntimeException(message);
	}
}
