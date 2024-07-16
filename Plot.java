
public class Plot extends Object{
	private int x;
	private int y;
	private int width;
	private int depth;

	public Plot() {
		this.y = 0;
		this.x = 0;
		width = 1;
		depth = 1;
	}
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	public Plot(Plot otherPlot) {
		this.x = otherPlot.x;
        this.y = otherPlot.y;
        this.width = otherPlot.width;
        this.depth = otherPlot.depth;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth=depth;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width=width;
	}
	public boolean overlaps(Plot plot) {

		if (plot.getX() >= this.x + this.width|| 
				plot.getX() + plot.getWidth() <= this.x || 
				plot.getY() >= this.y + this.depth || 
				plot.getY() + plot.getDepth() <= this.y) {
			//test overlap by comparing values for similarities
			return false;
		}else { 
			return true;
		}
	}
	public boolean encompasses(Plot plot) {
		if (plot.getX() >= this.x && 
				plot.getX() + plot.getWidth() <= this.x + this.width &&
				plot.getY() >= this.y &&
				plot.getY() + plot.getDepth() <= this.y + this.depth) {
			return true;
			//tests encompass by being less than width and depth
		}
		return false;
	}
	@Override
	public String toString() {
		return x + "," + y + "," + width + "," + depth;
	}
}
