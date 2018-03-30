//Stack : LIFO. push()/pop()
package step12.ex03;

import step12.ex02.LinkedList;

// 스택의 용도: 사용의 예 :
// - 웹 브라우저의  history 다룰 때
// - 웹사이드에서 breadcrumb navigation 구현할 때
// - 웹 페이지 UI의 이벤트를 처리할 때
public class Stack extends LinkedList {
    public void push(Object value) {
        this.add(value);
    }
    
    public Object pop() {
        if (head == tail)  //size()가 의미상 좋지만 속도!!
            return null;

        Bucket removedbucket = this.tail.prev;
        if (tail.prev.prev != null) {
            this.tail.prev.prev.next = tail;
            this.tail.prev = tail.prev.prev;            
        } else {
            head = tail;
            head.prev = null;
        }

        return removedbucket.value;
        
    }
}
