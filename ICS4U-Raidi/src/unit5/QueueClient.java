package unit5;

/**
 *
 * @author 1dingrai
 */
public class QueueClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Queue q = new Queue(10);

        // TEST CASE #1 - EMPTY QUEUE
        assert (q.front() == -1);
        assert (q.back() == -1);
        assert (q.size() == 0);
        assert (q.capacity() == 10);
        assert (q.isEmpty());
        assert (q.isFull() == false);

        // TEST CASE #2 - FILL THE QUEUE
        for (int i = 0; i < q.capacity(); i++) {
            q.enqueue(i);
            assert (q.front() == 0);
            assert (q.back() == i);
            assert (q.size() == i + 1);
            assert (q.capacity() == 10);
            assert (!q.isEmpty());

            if (i <= 8) {
                assert (!q.isFull());
            } else {
                assert (q.isFull());
            }

        }

        //TEST CASE #3 - OVERLOAD THE QUEUE
        q.enqueue(1);
        assert (q.front() == 0);
        assert (q.back() == q.capacity() - 1);
        assert (q.size() == q.capacity());
        assert (q.capacity() == 10);
        assert (!q.isEmpty());
        assert (q.isFull());

        //TEST CASE #4 - REMOVE SOMETHING FROM THE QUEUE WITH DEQUEUE
        assert (q.dequeue() == 0);
        assert (q.front() == 1);
        assert (q.back() == q.capacity() - 1);
        assert (q.size() == q.capacity() - 1);
        assert (q.capacity() == 10);
        assert (!q.isEmpty());
        assert (!q.isFull());

        //TEST CASE #5 - MAKE QUEUE EMPTY WITH MAKEEMPTY
        q.makeEmpty();

        assert (q.front() == -1);
        assert (q.back() == -1);
        assert (q.size() == 0);
        assert (q.capacity() == 10);
        assert (q.isEmpty());
        assert (!q.isFull());

        //TEST CASE #6 - TRY TO DEQUE FROM AN EMPTY QUEUE
        assert (q.dequeue() == null);
        
        assert (q.front() == -1);
        assert (q.back() == -1);
        assert (q.size() == 0);
        assert (q.capacity() == 10);
        assert (q.isEmpty());
        assert (!q.isFull());
    }

}
