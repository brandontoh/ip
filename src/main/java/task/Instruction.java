package task;

/**
 * Enum class for the different type of instructions
 * Also categorize the instructions into either command or task
 * Further categorize the instructions into either one part or two part instructions
 */
public enum Instruction {
    LIST (true, false, true, false),
    BYE (true, false, true, false),
    DONE (true, false,  false, true),
    TODO (false, true,  false, true),
    DEADLINE (false, true,  false, true),
    EVENT (false, true,  false, true),
    DELETE (true, false, false, true),
    FIND (true, true,  false, true);

    private final boolean isCommand;
    private final boolean isTask;
    private final boolean isOnePartInstruction;
    private final boolean isTwoPartInstruction;

    Instruction(boolean isCommand, boolean isTask, boolean isOnePartInstruction, boolean isTwoPartInstruction) {
        this.isCommand = isCommand;
        this.isTask = isTask;
        this.isOnePartInstruction = isOnePartInstruction;
        this.isTwoPartInstruction = isTwoPartInstruction;
    }

    public boolean isCommand() {
        return isCommand;
    }

    public boolean isTask() {
        return isTask;
    }

    public boolean isOnePartInstruction() {
        return isOnePartInstruction;
    }

    public boolean isTwoPartInstruction() {
        return isTwoPartInstruction;
    }

}
