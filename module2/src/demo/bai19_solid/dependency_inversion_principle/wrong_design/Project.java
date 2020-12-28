package demo.bai19_solid.dependency_inversion_principle.wrong_design;

public class Project {
    /**
     * Module cấp cao lúc này tạm hiểu là Project đang bị phụ thuộc vào module cấp thấp hơn
     * là Backend và Frontend, nếu như một ngày nào đó chúng ta muốn thay đổi Backend thành
     * PHP và Frontend thành Angular thì phải sửa code ở cả module cấp cao và module cấp thấp
     */
    private void build(){
        Backend backend = new Backend();
        Frontend frontend = new Frontend();
        backend.codeJava();
        frontend.codeJS();
    }

    public static void main(String[] args) {
        Project project = new Project();
        project.build();
    }
}
