package pi2tut.stunde03;

import java.awt.Color;

public class Farbverlauf {
	private static int colorToRGB(float colorPercent) {
		return Color.HSBtoRGB((float) colorPercent, 1, 1);
	}

	public int createColor() {
		return 0x39E4FF;
	}

	public int[] createColorArray() {
		return null;
	}

	public int[][] createColorArray2() {
		return null;
	}

	static void main() {
		GUI.createGUI(new Farbverlauf());
	}
}
