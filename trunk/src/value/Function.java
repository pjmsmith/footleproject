package value;

import java.util.List;

import expression.Sequence;
import Interpreter.Environment;
import Interpreter.ReturnException;

public class Function implements Value{
	private List<String> params;
	private Sequence sequence;
	
	public Function(List<String> params, Sequence seq)
	{
		this.params = params;
		sequence = seq;
	}
	
	public List<String> getParamList()
	{
		return params;
	}
	

	@Override
	public boolean isType(Value val) {
		// TODO Auto-generated method stub
		return val instanceof Function;
	}

	@Override
	public Environment getValue(Environment environment) throws ReturnException  {
		Environment newEnv = null;
		// run the function
		try
		{
			newEnv = sequence.getValue(environment);
		}
		catch (ReturnException e)
		{
			return new Environment(environment, null, e.getRetVal());
		}

		return new Environment(newEnv, null, new VoidValue());
	}

}
