package demo.bai19_solid.dependency_inversion_principle.true_design;

/**
 * Frontend phụ thuộc vào IDevelop(abstraction)
 */
class Frontend implements IDevelop{
    @Override
    public void develop() {
        this.codeJS();
    }
    private void codeJS(){
        System.out.println("Sử dụng code JS xây dựng FrontEnd");
    }

}
