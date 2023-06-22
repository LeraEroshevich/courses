public interface Action<T extends Action<T>> {
    T open(String url);
}
