import structure5.*;

/**
 * This class represents one Darwin instruction. Instructions contain two
 * parts: an opcode and an address. For instructions that do not perform jumps
 * (hop, left, right, infect), the address part is not used.
 * 
 * The fill instruction set is the following:
 * <p>
 * 
 * <pre>
 *  hop left right infect ifempty ifwall ifsame ifenemy ifrandom go
 * </pre>
 * 
 * 
 * The following instructions require a target address to jump to:
 * 
 * <pre>
ifempty, ifwall, ifsame, ifenemy, ifrandom, go</pre>
 * 
 * 
 *  
 */
public class Instruction {

	/** opcode for the hop instruction */
	public static final int HOP = 1;
	/** opcode for the left instruction */
	public static final int LEFT = 2;
	/** opcode for the right instruction */
	public static final int RIGHT = 3;
	/** opcode for the infect instruction */
	public static final int INFECT = 4;
	/** opcode for the ifempty instruction */
	public static final int IFEMPTY = 5;
	/** opcode for the ifwall instruction */
	public static final int IFWALL = 6;
	/** opcode for the ifsame instruction */
	public static final int IFSAME = 7;
	/** opcode for the ifenemy instruction */
	public static final int IFENEMY = 8;
	/** opcode for the ifrandom instruction */
	public static final int IFRANDOM = 9;
	/** opcode for the go instruction */
	public static final int GO = 10;
	/** opcode for the if2enemy instruction */
	public static final int IFTWOENEMY = 11;
	/** opcode for the ifeq instruction */
	public static final int IFEQ = 12;
	/** opcode to increment memory **/
	public static final int INC = 13;
	/** opcode to decrement memory **/
	public static final int DEC = 14;
	/** opcode for set **/
	public static final int SET=15;

	protected int opcode; /** the opcode */
	protected int address; /** the address */
	
	/** number for memory comparison is "intelligent" creatures **/
	protected int testNum; 

	/**
	* Creates a new instruction. address is the target of the operation, if one
	 * is needed. Otherwise it is not used. @pre 0 <= opcode <= SET.
	 */
	public Instruction(int opcode, int address) {
		this(opcode, 0, address);
	}
		
	
	/**
	 * Creates a new instruction. address is the target of the operation, if one
	 * is needed. Otherwise it is not used. Also includes support for "smart"
	 * creatures via memory comparison
	 * @pre 0 <= opcode <= IFEQ.
	 */
	public Instruction(int opcode, int testNum, int address) {
		Assert.pre(0 < opcode && opcode <= SET, "Bad opcode");
		this.opcode = opcode;
		this.address = address;
		this.testNum = testNum;
	}

	/**
	 * Returns the opcode @post returns the opcode
	 */
	public int getOpcode() {
		return opcode;
	}

	/**
	 * Returns the addrss @post returns the address
	 */
	public int getAddress() {
		return address;
	}

	/**
	 * Returns the number against with memory is to be compared
	 */
	public int getTestCase() {
		return testNum;
	}
	
	/**
	 * Returns a printable representation of an Instruction
	 */
	public String toString() {
		switch (opcode) {
			case HOP :
				return "hop";
			case LEFT :
				return "left";
			case RIGHT :
				return "right";
			case INFECT :
				return "infect " + address;
			case IFEMPTY :
				return "ifempty " + address;
			case IFWALL :
				return "ifwall " + address;
			case IFSAME :
				return "ifsame " + address;
			case IFENEMY :
				return "ifenemy " + address;
			case IFRANDOM :
				return "ifrandom " + address;
			case GO :
				return "go " + address;
			case IFTWOENEMY:
				return "if2enemy " + address;
			case IFEQ:
				return "ifeq "+ testNum + " " + address;
			case INC:
				return "inc";
			case DEC:
				return "dec";
			case SET:
				return "set "+ address;
			default :
				return "BAD INSTRUCTION: " + opcode + " " + address;
		}
	}
}
