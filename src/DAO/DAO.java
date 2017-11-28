package DAO;

import java.util.Iterator;
import java.util.List;

public interface DAO <ValueObject, Key>{
	public boolean insert ( ValueObject vo);
	public boolean delete (Key key);
	public boolean update (ValueObject vo);
	public ValueObject findByKey (Key key);
	public Iterator<ValueObject> findAll ();
}
