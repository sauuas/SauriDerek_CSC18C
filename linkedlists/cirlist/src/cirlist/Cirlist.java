/**
 * Derek Sauri
 * circular linked list
 */
package cirlist;

/**
 *
 * @author derek
 */
public class Cirlist<T> {
  public T data;
 public Cirlist next;
 public Cirlist back;
    
 public Cirlist(T data){
        this.data = data;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        LinkedList theList = new LinkedList();
        
        // push some data
        theList.push('B');
        theList.push(20);
        theList.push(100.25);
        theList.push("cool");
        theList.display();
        //pop first value
        System.out.println("popped off stack: "+theList.pop().data);
        //peek at value
        theList.peek();
        //insert before
        //add to bottom of list
        System.out.println("add to bottom of stack");
        theList.add(21);
        theList.display();
        //"peek" at bottom of stack
        System.out.println("gander at bottom of stack");
        theList.gander();
        //"pop" the bottom of the stack
         System.out.println("clipped off stack: "+theList.clip().data);
        System.out.println("show insert before");
        theList.insertBef("before",20);
        theList.display();
        //insert after
        System.out.println("show insert after");
        theList.insertAft("after",20);
        theList.display();
        //remove
        System.out.println("removed "+theList.remove(20).data+" from stack");
        //empty list
        theList.isEmpty();
        theList.clear();
        theList.isEmpty();
    }
    
}
class LinkedList<T>{
    public Cirlist head;
    public Cirlist tail;
    
    LinkedList(){
   head = null;
   tail = null;
    }
    // checks if list is empty
    public void isEmpty(){
        if(head == null){
            System.out.println("the stack is empty now");
        }
        else{
            System.out.println("the stack is not empty");
        }
    }
    //displays whole linked list
    public void display(){
        Cirlist theLink = head;
        
        System.out.println("display list");
        while(theLink != tail){
            System.out.println("link: "+theLink.data);
            theLink = theLink.next;
            System.out.println();
        }
        if(theLink == tail){
             System.out.println("link: "+theLink.data);
             System.out.println();
        }
    }
    //pushes new value to top
    public void push(T data){
        Cirlist newLink = new Cirlist(data);
        System.out.println("push: "+newLink.data);
        if(head != null){
        newLink.next = head;
        head.back = newLink;
        head = newLink;
        }
        else{
            newLink.next = head;
             head = newLink;
             tail = head;
             head.back = tail;
             tail.next = head;
        }
    }
    //adds new value to bottom
    public void add(T data){
        Cirlist newLink = new Cirlist(data);
        System.out.println("add: "+newLink.data);
        if(tail != null){
            newLink.back = tail;
            tail.next = newLink;
            tail = newLink;
        }
        else{
           newLink.back = tail;
           tail = newLink;
           head = tail;
        }
    }
    //removes top value
    public Cirlist pop(){
        Cirlist linkRec = head;
        if(head != null){
            head = head.next;
        }
        else{
            System.out.println("stack is empty");
        }
        return linkRec;
    }
    //removes bottom value
    public Cirlist clip(){
        Cirlist linkRec = tail;
        if(tail != null){
            tail = tail.back;
            tail.next = null;
        }
        else{
            System.out.println("stack is empty");
        }
        return linkRec;
    }
    //looks at, but does not remove top data
    public void peek(){
        System.out.println("top of stack "+head.data);
        System.out.println();
    }
    //looks at, but does not remove bottom data
    public void gander(){
         System.out.println("bottom of stack "+tail.data);
        System.out.println();
    }
    // resets list
    public void clear(){
      head = null;
      tail = null;
    }
    //removes specific item from list
    public Cirlist remove(T data){
       Cirlist currentLink = head;
       Cirlist previousLink = head;
       Cirlist nextLink = head;
       
       //search for data
       while(currentLink.data != data){
           if(currentLink.next == head){
               System.out.println("data not found.");
               return null;
           }
           else{
               previousLink = currentLink;
               currentLink = currentLink.next;
               nextLink = currentLink.next;
           }
       }
       //deal with link that has data
       if(currentLink == head){
           System.out.println("First link: "+currentLink.data);
           head = head.next;
       }
       else{
       System.out.println("current link: "+currentLink.data);
       nextLink.back = currentLink.back;
       previousLink.next = currentLink.next;
       }
       return currentLink;
    }
    //insert new data before certain value
    public void insertBef(T data, T value){
        Cirlist newLink = new Cirlist(data);
        Cirlist currentLink = head;
        Cirlist previousLink = head;
       
        while(currentLink.data != value){
           if(currentLink.next == head){
               System.out.println("data to insert before not found.");
               return;
           }
           else{
               previousLink = currentLink;
               currentLink = currentLink.next;
           }
       }
        if(currentLink == head){
        newLink.next = head;
        head.back = newLink;
        head = newLink;
        }
        else{
            previousLink.next = newLink;
            newLink.back = previousLink;
            newLink.next = currentLink;
            currentLink.back = newLink;
        }
    }
    //insert new data after certain value
    public void insertAft(T data,T value){
        Cirlist newLink = new Cirlist(data);
        Cirlist currentLink = head;
        Cirlist nextLink = head;
       
        while(currentLink.data != value){
           if(currentLink.next == head){
                System.out.println("data to insert after not found.");
               return;
           }
           else{
               currentLink = currentLink.next;
           }
       }
        nextLink.back = newLink;
        newLink.next = currentLink.next;
        newLink.back = currentLink;
        currentLink.next = newLink;
    }

}
