interface Expression{
    public Address generateCode();
    public void generateJump(Label lyes, Label lno);
}
