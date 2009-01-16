package expression;

import value.BoolValue;
import value.FloatValue;
import value.IdValue;
import value.IntValue;
import value.Value;
import Interpreter.Environment;
import Interpreter.ReturnException;

public class Not implements Expression {
	
	private Expression one;
	
	public Not(Expression one)
	{
		this.one = one;
	}

	@Override
	public Environment getValue(Environment environment) throws ReturnException {
		Environment nEnv = one.getValue(environment);
		Value leftSide = nEnv.value;
		nEnv = nEnv.next;
		
		// check to see if one of them is an ID
		if (leftSide instanceof IdValue)
		{
			String name = ((IdValue)leftSide).getInternalValue();
			Environment environ = Environment.findIDInList(name, nEnv);
			// check for null
			if (environ != null)
			{
				leftSide = environ.value;
			}
			else
			{
				// TODO: Exception, type not found
			}
		}
		// now check to make sure its a bool
		if (!(leftSide instanceof BoolValue))
		{
			// TODO: throw an exception here
		}
		
		boolean ls = ((BoolValue)leftSide).getInternalValue();
			
		return new Environment(environment, null, new BoolValue(!ls));
	}

}
