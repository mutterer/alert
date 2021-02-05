import ij.*;
import ij.process.*;
import ij.gui.*;
import java.awt.*;
import ij.plugin.*;
import ij.plugin.frame.*;

public class Alert_ implements PlugIn {
	private int delay;
	private String colorString;
	private Color color;
	private String what;

	public void run(String arg) {
		GenericDialog gd = new GenericDialog("Alert");
		gd.addChoice("Object", new String[] { "Status", "Image" }, "Status");
		gd.addChoice("Color", new String[] { "Red", "Orange", "Green" }, "Green");
		gd.addNumericField("Duration", 1000);
		gd.showDialog();
		if (gd.wasCanceled())
			return;
		what = (String) gd.getNextChoice();
		colorString = (String) gd.getNextChoice();
		delay = (int) gd.getNextNumber();
		
		if (colorString.startsWith("#")) 
			color = Colors.decode(colorString, IJ.getInstance().backgroundColor);
		else 
			color = Colors.getColor(colorString, IJ.getInstance().backgroundColor);
		
		switch (what) {
		case "Image":

			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						ImagePlus imp = IJ.getImage();
						if (imp != null) {
							Color previousColor = imp.getWindow().getBackground();
							imp.getWindow()
									.setBackground(color);
							Thread.sleep(delay);
							if (delay>0)
							imp.getWindow().setBackground(previousColor);
						}

					} catch (Exception e) {
					}

				}
			}).start();
			break;
		case "Status":
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						IJ.getInstance().getStatusBar()
								.setBackground(color);
						Thread.sleep(delay);
						if (delay>0)
						IJ.getInstance().getStatusBar().setBackground(IJ.getInstance().backgroundColor);
					} catch (Exception e) {
					}
				}
			}).start();

			break;
		}
	}

}
