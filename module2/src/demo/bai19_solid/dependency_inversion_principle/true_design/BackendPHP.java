package demo.bai19_solid.dependency_inversion_principle.true_design;

public class BackendPHP implements IDevelop {
    @Override
    public void develop() {
        this.codePHP();
    }

    private void codePHP(){
        System.out.println("Sử dụng code PHP xây dựng Backend");
    }
}
