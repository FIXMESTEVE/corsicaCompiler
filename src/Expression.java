interface Expression{
    Address generateCode();
    void generateJump(Label ltrue, Label lfalse);
}
