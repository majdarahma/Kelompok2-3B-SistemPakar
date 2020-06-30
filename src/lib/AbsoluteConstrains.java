package lib;


import java.awt.Dimension;
import java.awt.Point;
import java.io.Serializable;

public class AbsoluteConstrains implements Serializable {
  
  /**
	 * 
	 */
	private static final long serialVersionUID = 6677434461308344846L;

public int x;
  
  public int y;
  
  public int width = -1;
  
  public int height = -1;
  
  public AbsoluteConstrains(Point paramPoint) {
    this(paramPoint.x, paramPoint.y);
  }
  
  public AbsoluteConstrains(int paramInt1, int paramInt2) {
    this.x = paramInt1;
    this.y = paramInt2;
  }
  
  public AbsoluteConstrains(Point paramPoint, Dimension paramDimension) {
    this.x = paramPoint.x;
    this.y = paramPoint.y;
    if (paramDimension != null) {
      this.width = paramDimension.width;
      this.height = paramDimension.height;
    } 
  }
  
  public AbsoluteConstrains(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.x = paramInt1;
    this.y = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
  }
  
  public int getX() {
    return this.x;
  }
  
  public int getY() {
    return this.y;
  }
  
  public int getWidth() {
    return this.width;
  }
  
  public int getHeight() {
    return this.height;
  }
  
  public String toString() {
    return super.toString() + " [x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + "]";
  }
}
