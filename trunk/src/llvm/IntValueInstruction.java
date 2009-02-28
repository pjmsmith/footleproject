package llvm;

/**
 * llvm: IntValueInstruction
 * <p/>
 * Description:
 *
 * @author Patrick J. Smith
 * @date Feb 23, 2009
 */
public class IntValueInstruction extends LLVMInstruction {
    private int value;
    private static final String type = "i32";

    public IntValueInstruction(int target, int value)
    {
        super(target);
        this.value = value << 2;
    }

    public String toString()
    {
        String s=  "%" + super.getTargetRegister() + " = alloca " + type;  //make space
        s+= "\nstore " + type + " 0x" + Integer.toHexString(value).toUpperCase()
                + ", " + type + "* %" + super.getTargetRegister() + ", align 4";  //store in register
        return s;
    }
}
