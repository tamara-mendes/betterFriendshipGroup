import java.util.ArrayList;
import java.util.List;

public class Control {

	private List<Double> values;
	
	public Control() {
		values = new ArrayList<Double>();
	}
	
	public void run() {

		boolean success = UtilFile.read(this, "input.in");
		if(success) {
			finish();
		}
	}
	
	public void newInstance(List<String> lines, int n) {
		values.add(new GraphControl().run(lines, n));
	}
	
	public void finish() {
		showOut(values);
	}
	
	private void showOut(List<Double> values) {
		for(Double v : values) {
			System.out.println(Util.round(v, 3));
		}
	}
	
}
