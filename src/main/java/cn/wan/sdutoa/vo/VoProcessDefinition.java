package cn.wan.sdutoa.vo;

/**
 * Created by 万洪基 on 2017/3/28.
 */
public class VoProcessDefinition {

    private String name;

    private String key;

    private int version;

    private String deploymentId;

    private String resourceName;

    private String diagramResourceName;

    private String action;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getDiagramResourceName() {
        return diagramResourceName;
    }

    public void setDiagramResourceName(String diagramResourceName) {
        this.diagramResourceName = diagramResourceName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "VoProcessDefinition{" +
                "name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", version='" + version + '\'' +
                ", deploymentId='" + deploymentId + '\'' +
                ", resourceName='" + resourceName + '\'' +
                ", diagramResourceName='" + diagramResourceName + '\'' +
                '}';
    }
}
