package gwt.scene.showcase.client;

import java.util.Date;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

import gwt.scene.core.client.ModuleLoader;
import gwt.scene.core.client.collections.JsArray;
import gwt.scene.core.client.collections.JsObject;
import gwt.scene.core.client.json.JSON;
import gwt.scene.ui.client.Button;
import gwt.scene.ui.client.Container;
import gwt.scene.ui.client.FlowPane;
import gwt.scene.ui.client.Scene;
import gwt.scene.ui.d3.client.D3;
import gwt.scene.ui.nvd3.client.DiscreteBarChart;
import gwt.scene.ui.nvd3.client.HistoricalBarChart;
import gwt.scene.ui.nvd3.client.LineChart;
import gwt.scene.ui.nvd3.client.LinePlusBarChart;
import gwt.scene.ui.nvd3.client.MultiBarChart;
import gwt.scene.ui.nvd3.client.ScatterChart;

public class Showcase_NVD3 implements EntryPoint, Callback<Void, Exception> {

	public void onModuleLoad() {
		ModuleLoader.require(this, "UI", "NVD3");
	}

	boolean b1 = false;

	@Override
	public void onSuccess(Void result) {
		// uiBinderTest();
		// uiBinderTest2();
		// flowPaneTest();
		// lineChart();
		// discreteBarChart();
		// historicalBar();
		// linePlusBarChart();
		// multiBarChart();
		scatterChart();
	}

	private void scatterChart() {
		Scene scene = new Scene();
		scene.addStyleName("scene");

		ScatterChart chart = new ScatterChart();
		chart.setData(scatterChartData(4, 100));

		chart.setFlex("1");
		scene.add(chart);
	}

	private JsArray scatterChartData(int groups, int points) {
		JsArray data = JsArray.create();

		String[] shapes = new String[] { "circle", "cross", "triangle-up", "triangle-down", "diamond",
				"square" };

		for (int i = 0; i < groups; i++) {
			double size = Math.round(Math.random() * 100D) / 100D;
			GWT.log(">>>>"+size);
			JsArray values = JsArray.create();
			for (int j = 0; j < points; j++) {
				values.push(JsObject.create()
						.set("x", random())
						.set("y", random())
						.set("size", size)
						.set("shape", shapes[i % shapes.length]));
			}

			data.push(JsObject.create()
					.set("key", "Group " + i)
					.set("values", values));
		}
		
		return data;
	}

	private native double random() /*-{
		return $wnd.d3.random.normal()();
	}-*/;

	private void multiBarChart() {
		Scene scene = new Scene();
		scene.addStyleName("scene");

		MultiBarChart chart = new MultiBarChart();
		chart.setData(multiBarChartData());

		chart.setFlex("1");
		scene.add(chart);
	}

	private JsArray multiBarChartData() {
		return D3.range(3).map((o) -> {
			return JsObject.create()
					.set("key", "Stream" + o.get("index"))
					.set("values", D3.range(11).map((o2) -> {
						return JsObject.create()
								.set("y",
										10D + Math.random() * 100D
												* (Math.floor(Math.random() * 100D) % 2D == 0 ? 1D : -1D))
								.set("x", o2.get("index"));
					}));
		});
	}

	private void linePlusBarChart() {
		Scene scene = new Scene();
		scene.addStyleName("scene");

		LinePlusBarChart chart = new LinePlusBarChart();
		chart.setData(linePlusBarChartData());

		chart.getXAxis().setTickFormat((d) -> {
			Date date = new Date(((Double) d).longValue());
			return DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT).format(date);
		}).showMaxMin(true);

		chart.getX2Axis().setTickFormat((d) -> {
			Date date = new Date(((Double) d).longValue());
			return DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT).format(date);
		}).showMaxMin(true);

		chart.getY2Axis().setTickFormat("',f", (s) -> "$" + s);

		chart.setFlex("1");
		scene.add(chart);
	}

	private JsArray linePlusBarChartData() {
		JsArray bar = JSON.parse(
				"[ [ 1136005200000 , 1271000.0] , [ 1138683600000 , 1271000.0] , [ 1141102800000 , 1271000.0] , [ 1143781200000 , 0] , [ 1146369600000 , 0] , [ 1149048000000 , 0] , [ 1151640000000 , 0] , [ 1154318400000 , 0] , [ 1156996800000 , 0] , [ 1159588800000 , 3899486.0] , [ 1162270800000 , 3899486.0] , [ 1164862800000 , 3899486.0] , [ 1167541200000 , 3564700.0] , [ 1170219600000 , 3564700.0] , [ 1172638800000 , 3564700.0] , [ 1175313600000 , 2648493.0] , [ 1177905600000 , 2648493.0] , [ 1180584000000 , 2648493.0] , [ 1183176000000 , 2522993.0] , [ 1185854400000 , 2522993.0] , [ 1188532800000 , 2522993.0] , [ 1191124800000 , 2906501.0] , [ 1193803200000 , 2906501.0] , [ 1196398800000 , 2906501.0] , [ 1199077200000 , 2206761.0] , [ 1201755600000 , 2206761.0] , [ 1204261200000 , 2206761.0] , [ 1206936000000 , 2287726.0] , [ 1209528000000 , 2287726.0] , [ 1212206400000 , 2287726.0] , [ 1214798400000 , 2732646.0] , [ 1217476800000 , 2732646.0] , [ 1220155200000 , 2732646.0] , [ 1222747200000 , 2599196.0] , [ 1225425600000 , 2599196.0] , [ 1228021200000 , 2599196.0] , [ 1230699600000 , 1924387.0] , [ 1233378000000 , 1924387.0] , [ 1235797200000 , 1924387.0] , [ 1238472000000 , 1756311.0] , [ 1241064000000 , 1756311.0] , [ 1243742400000 , 1756311.0] , [ 1246334400000 , 1743470.0] , [ 1249012800000 , 1743470.0] , [ 1251691200000 , 1743470.0] , [ 1254283200000 , 1519010.0] , [ 1256961600000 , 1519010.0] , [ 1259557200000 , 1519010.0] , [ 1262235600000 , 1591444.0] , [ 1264914000000 , 1591444.0] , [ 1267333200000 , 1591444.0] , [ 1270008000000 , 1543784.0] , [ 1272600000000 , 1543784.0] , [ 1275278400000 , 1543784.0] , [ 1277870400000 , 1309915.0] , [ 1280548800000 , 1309915.0] , [ 1283227200000 , 1309915.0] , [ 1285819200000 , 1331875.0] , [ 1288497600000 , 1331875.0] , [ 1291093200000 , 1331875.0] , [ 1293771600000 , 1331875.0] , [ 1296450000000 , 1154695.0] , [ 1298869200000 , 1154695.0] , [ 1301544000000 , 1194025.0] , [ 1304136000000 , 1194025.0] , [ 1306814400000 , 1194025.0] , [ 1309406400000 , 1194025.0] , [ 1312084800000 , 1194025.0] , [ 1314763200000 , 1244525.0] , [ 1317355200000 , 475000.0] , [ 1320033600000 , 475000.0] , [ 1322629200000 , 475000.0] , [ 1325307600000 , 690033.0] , [ 1327986000000 , 690033.0] , [ 1330491600000 , 690033.0] , [ 1333166400000 , 514733.0] , [ 1335758400000 , 514733.0]]")
				.cast();
		JsArray line = JSON.parse(
				"[ [ 1136005200000 , 71.89] , [ 1138683600000 , 75.51] , [ 1141102800000 , 68.49] , [ 1143781200000 , 62.72] , [ 1146369600000 , 70.39] , [ 1149048000000 , 59.77] , [ 1151640000000 , 57.27] , [ 1154318400000 , 67.96] , [ 1156996800000 , 67.85] , [ 1159588800000 , 76.98] , [ 1162270800000 , 81.08] , [ 1164862800000 , 91.66] , [ 1167541200000 , 84.84] , [ 1170219600000 , 85.73] , [ 1172638800000 , 84.61] , [ 1175313600000 , 92.91] , [ 1177905600000 , 99.8] , [ 1180584000000 , 121.191] , [ 1183176000000 , 122.04] , [ 1185854400000 , 131.76] , [ 1188532800000 , 138.48] , [ 1191124800000 , 153.47] , [ 1193803200000 , 189.95] , [ 1196398800000 , 182.22] , [ 1199077200000 , 198.08] , [ 1201755600000 , 135.36] , [ 1204261200000 , 125.02] , [ 1206936000000 , 143.5] , [ 1209528000000 , 173.95] , [ 1212206400000 , 188.75] , [ 1214798400000 , 167.44] , [ 1217476800000 , 158.95] , [ 1220155200000 , 169.53] , [ 1222747200000 , 113.66] , [ 1225425600000 , 107.59] , [ 1228021200000 , 92.67] , [ 1230699600000 , 85.35] , [ 1233378000000 , 90.13] , [ 1235797200000 , 89.31] , [ 1238472000000 , 105.12] , [ 1241064000000 , 125.83] , [ 1243742400000 , 135.81] , [ 1246334400000 , 142.43] , [ 1249012800000 , 163.39] , [ 1251691200000 , 168.21] , [ 1254283200000 , 185.35] , [ 1256961600000 , 188.5] , [ 1259557200000 , 199.91] , [ 1262235600000 , 210.732] , [ 1264914000000 , 192.063] , [ 1267333200000 , 204.62] , [ 1270008000000 , 235.0] , [ 1272600000000 , 261.09] , [ 1275278400000 , 256.88] , [ 1277870400000 , 251.53] , [ 1280548800000 , 257.25] , [ 1283227200000 , 243.1] , [ 1285819200000 , 283.75] , [ 1288497600000 , 300.98] , [ 1291093200000 , 311.15] , [ 1293771600000 , 322.56] , [ 1296450000000 , 339.32] , [ 1298869200000 , 353.21] , [ 1301544000000 , 348.5075] , [ 1304136000000 , 350.13] , [ 1306814400000 , 347.83] , [ 1309406400000 , 335.67] , [ 1312084800000 , 390.48] , [ 1314763200000 , 384.83] , [ 1317355200000 , 381.32] , [ 1320033600000 , 404.78] , [ 1322629200000 , 382.2] , [ 1325307600000 , 405.0] , [ 1327986000000 , 456.48] , [ 1330491600000 , 542.44] , [ 1333166400000 , 599.55] , [ 1335758400000 , 583.98] ]")
				.cast();

		return JsArray.create()
				.push(JsObject.create()
						.set("key", "Quantity")
						.set("bar", true)
						.set("values", bar.map((o) -> JsObject.create()
								.set("x", ((JsArray) o.get("currentValue")).get(0))
								.set("y", ((JsArray) o.get("currentValue")).get(1)))))
				.push(JsObject.create()
						.set("key", "Price")
						.set("values", line.map((o) -> JsObject.create()
								.set("x", ((JsArray) o.get("currentValue")).get(0))
								.set("y", ((JsArray) o.get("currentValue")).get(1)))));
	}

	private void historicalBar() {
		Scene scene = new Scene();
		scene.addStyleName("scene");

		HistoricalBarChart chart = new HistoricalBarChart();
		chart.setData(historicalBarChartData());
		chart.getXAxis().setLabel("Time (s)")
				.setTickFormat(",.1f");
		chart.getYAxis().setLabel("Voltage (v)")
				.setTickFormat(",.2f");

		chart.setFlex("1");
		scene.add(chart);
	}

	private JsArray historicalBarChartData() {
		JsArray values = JsArray.create();

		for (int i = 0; i < 100; i++) {
			values.push(JsObject.create()
					.set("x", i)
					.set("y", Math.sin(i / 10D) * Math.random() * 100));
		}

		return JsArray.create()
				.push(JsObject.create()
						.set("values", values)
						.set("key", "Sine Wave")
						.set("color", "#ff7f0e"));
	}

	private void discreteBarChart() {
		Scene scene = new Scene();
		scene.addStyleName("scene");

		DiscreteBarChart chart = new DiscreteBarChart();
		chart.setData(discreteBarChartData());

		chart.setFlex("1");
		scene.add(chart);
	}

	private JsArray discreteBarChartData() {
		return JsArray.create()
				.push(JsObject.create()
						.set("key", "Cumulative Return")
						.set("values", JsArray.create()
								.push(JsObject.create()
										.set("label", "A")
										.set("value", 29.765957771107))
								.push(JsObject.create()
										.set("label", "B")
										.set("value", 0))
								.push(JsObject.create()
										.set("label", "C")
										.set("value", 32.807804682612))
								.push(JsObject.create()
										.set("label", "D")
										.set("value", 196.45946739256))
								.push(JsObject.create()
										.set("label", "E")
										.set("value", 0.19434030906893))
								.push(JsObject.create()
										.set("label", "F")
										.set("value", 98.079782601442))
								.push(JsObject.create()
										.set("label", "G")
										.set("value", 13.925743130903))
								.push(JsObject.create()
										.set("label", "H")
										.set("value", 5.1387322875705))));
	}

	private void lineChart() {
		Scene scene = new Scene();
		scene.addStyleName("scene");

		LineChart chart = new LineChart();
		chart.setData(sinAndCos());
		// chart.update();

		new Timer() {
			@Override
			public void run() {

				chart.setData(sinAndCos());

			}
		}.schedule(3333);
		;

		chart.setFlex("1");
		scene.add(chart);
	}

	private JsArray sinAndCos() {
		JsArray sin = JsArray.create();
		JsArray sin2 = JsArray.create();
		JsArray cos = JsArray.create();
		JsArray rand = JsArray.create();
		JsArray rand2 = JsArray.create();

		for (int i = 0; i < 100; i++) {
			sin.push(JsObject.create()
					.set("x", i)
					.set("y", i % 10 == 5 ? null : Math.sin(i / 10D)));
			sin2.push(JsObject.create()
					.set("x", i)
					.set("y", Math.sin(i / 5D) * 0.4 - 0.25));
			cos.push(JsObject.create()
					.set("x", i)
					.set("y", 0.5 * Math.cos(i / 10D)));
			rand.push(JsObject.create()
					.set("x", i)
					.set("y", Math.random() / 10));
			rand2.push(JsObject.create()
					.set("x", i)
					.set("y", Math.cos(i / 10D) + Math.random() / 10D));
		}

		return JsArray.create()
				.push(JsObject.create()
						.set("area", true)
						.set("values", sin)
						.set("key", "Sin Wave")
						.set("color", "#ff7f0e")
						.set("strokeWidth", 4)
						.set("classed", "dashed"))
				.push(JsObject.create()
						.set("values", cos)
						.set("key", "Cosine Wave")
						.set("color", "#2ca02c"))
				.push(JsObject.create()
						.set("values", rand)
						.set("key", "Random Points")
						.set("color", "#2222ff"))
				.push(JsObject.create()
						.set("values", rand2)
						.set("key", "Random Cosine")
						.set("color", "#667711")
						.set("strokeWidth", 3.5))
				.push(JsObject.create()
						.set("area", true)
						.set("values", sin2)
						.set("key", "Fill opacity")
						.set("color", "#EF9CFB")
						.set("fillOpacity", 0.1));
	}

	private void uiBinderTest() {
		Scene scene = new Scene();
		scene.addStyleName("scene");

		Container c = new Container();
		c.setFlex("1");
		c.setPadding("5px 15px");
		scene.add(c);

		c.add(new UiBinderForm01());
	}

	private void uiBinderTest2() {
		Scene scene = new Scene();
		scene.addStyleName("scene");

		Container c = new Container();
		c.setFlex("1");
		c.setPadding("5px 15px");
		scene.add(c);

		c.add(new UiBinderForm02());
	}

	@SuppressWarnings("unused")
	private void flowPaneTest() {
		Scene scene = new Scene();
		scene.addStyleName("scene");

		FlowPane flowPane = new FlowPane();
		flowPane.setBorder("1px solid #ccc");
		flowPane.setFlex("1");
		scene.add(flowPane);

		Button btn = new Button("Hello, World!");
		// btn.setFlex("1");
		flowPane.add(btn);

		btn = new Button("Hello, World!");
		// btn.setFlex("1");
		flowPane.add(btn);

		btn = new Button("Hello, World!");
		// btn.setFlex("1");
		flowPane.add(btn);

		btn = new Button("Hello, World!");
		// btn.setFlex("1");
		flowPane.add(btn);

		btn = new Button("Hello, World!");
		// btn.setFlex("1");
		flowPane.add(btn);

		btn = new Button("Hello, World!");
		// btn.setFlex("1");
		flowPane.add(btn);

		btn = new Button("Hello, World!");
		// btn.setFlex("1");
		flowPane.add(btn);

		btn = new Button("Hello, World!");
		// btn.setFlex("1");
		flowPane.add(btn);

		btn = new Button("Hello, World!");
		// btn.setFlex("1");
		flowPane.add(btn);

		btn = new Button("Hello, World!");
		// btn.setFlex("1");
		flowPane.add(btn);

		btn = new Button("Hello, World!");
		// btn.setFlex("1");
		flowPane.add(btn);

		btn = new Button("Hello, World!");
		// btn.setFlex("1");
		flowPane.add(btn);

		btn = new Button("Hello, World!");
		// btn.setFlex("1");
		flowPane.add(btn);

		btn = new Button("Hello, World!");
		// btn.setFlex("1");
		flowPane.add(btn);
	}

	@Override
	public void onFailure(Exception reason) {
		Window.alert(reason.getMessage());
	}
}
