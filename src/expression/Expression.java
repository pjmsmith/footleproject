package expression;

import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import value.Value;

public interface Expression {
	public Environment getValue(Environment environment) throws ReturnException, TypeException;
}
