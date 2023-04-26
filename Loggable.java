// version 0.2
class Loggable<T> {
  private final T value;
  private final String log;

  private Loggable(T value, String log) {
    this.value = value;
    this.log = log;
  }

  public static <T> Loggable<T> of(T value) {
    return new Loggable<>(value, "");
  }

  public <R> Loggable<R> flatMap(Transformer<? super T, ? extends Loggable<? extends R>> transformer) {
    Loggable<? extends R> l = transformer.transform(this.value);
    return new Loggable<>(l.value, l.log + this.log);
  }

  public String toString() {
    return "value: " + this.value + ", log: " + this.log;
  }
}
