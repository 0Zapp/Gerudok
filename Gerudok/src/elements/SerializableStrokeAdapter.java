package elements;

import java.awt.BasicStroke;
import java.awt.Shape;
import java.awt.Stroke;
import java.io.IOException;
import java.io.Serializable;

public class SerializableStrokeAdapter implements Stroke, Serializable {
	Stroke stroke;

	public SerializableStrokeAdapter(Stroke s){
		this.stroke = s;
	}

	private void writeObject(java.io.ObjectOutputStream out) throws IOException{
		if (stroke instanceof BasicStroke) {
			BasicStroke s = (BasicStroke) stroke;
			out.writeFloat(s.getLineWidth());
			out.writeInt(s.getEndCap());
			out.writeInt(s.getLineJoin());
		}
     }
	
    private void readObject(java.io.ObjectInputStream in) 
     		throws IOException, ClassNotFoundException{
    	stroke = new BasicStroke(in.readFloat(), in.readInt(), in.readInt());
     }
		
	
	
	public Shape createStrokedShape(Shape p) {
		return stroke.createStrokedShape(p);
	}
}
