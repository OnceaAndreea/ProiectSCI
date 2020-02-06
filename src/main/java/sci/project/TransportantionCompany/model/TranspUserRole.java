package sci.project.TransportantionCompany.model;

public enum TranspUserRole {

    ADMIN(1),REGULAR(2),VISITOR(3);

    private int order;

    TranspUserRole(int order) {
        this.order = order;
    }
}
