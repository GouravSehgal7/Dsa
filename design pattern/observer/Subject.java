package observer;

public interface Subject {
    void Subscribe(Observer ob);
    void Unsubscribe(Observer ob);
    // notify on video upload automatically send notification
    void notifyChange();
}
