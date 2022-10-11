package designpatterns.Adapter;

public class ServicesAdapter implements ServicesInterface {
    private ServicesInterface service;

    public ServicesAdapter(ServicesInterface service) {
        this.service = service;
    }

    @Override
    public ServicesInterface getService() {
        return service.getService();
    }
}

