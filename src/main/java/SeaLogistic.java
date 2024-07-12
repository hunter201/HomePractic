public class SeaLogistic extends TransportLogistic {

    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
