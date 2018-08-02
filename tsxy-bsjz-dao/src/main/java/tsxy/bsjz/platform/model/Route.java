package tsxy.bsjz.platform.model;

import java.util.List;

public class Route {
    private Integer id;

    private String name;

    private String title;

    private String path;

    private Integer parentId;

    private String component;

    private String code;

    private String iconClass;

    private Integer roleNumber;

    //此路由下的子路由们的信息
    private List<Route> childRoutes;

    //此路由上的父路由信息
    private Route parentRoute;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component == null ? null : component.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass == null ? null : iconClass.trim();
    }

    public Integer getRoleNumber() {
        return roleNumber;
    }

    public void setRoleNumber(Integer roleNumber) {
        this.roleNumber = roleNumber;
    }

    public List<Route> getChildRoutes() {
        return childRoutes;
    }

    public void setChildRoutes(List<Route> childRoutes) {
        this.childRoutes = childRoutes;
    }

    public Route getParentRoute() {
        return parentRoute;
    }

    public void setParentRoute(Route parentRoute) {
        this.parentRoute = parentRoute;
    }
}