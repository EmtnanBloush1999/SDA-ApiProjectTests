package test_data;

public class PetTagClass {

    /**
     * "tags": [
     * *     {
     * *       "id": 0,
     * *       "name": "string"
     * *     }
     * *   ],
     */

    private long id;
    private String name;

    public PetTagClass() {
    }

    public PetTagClass(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
