public class DataMember {
    String name;
    int id;
    String add;

    // DataMember(){
    //     this("jyoti",56);
    // }
    
    DataMember(String name,int id){
        this.name=name;
        this.id=id;

    }
    void display(){
        System.out.println(name);
        System.out.println(id);
    }
    public static void main(String[] args) {
        DataMember obj=new DataMember("jyoti",45);
        obj.display();
        
    }
    
    
}
