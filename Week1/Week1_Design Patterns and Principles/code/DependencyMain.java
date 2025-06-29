public class DependencyMain {

    interface CustomerRepository {
        String findCustomerById(String id);
    }

    static class CustomerRepositoryImpl implements CustomerRepository {
        public String findCustomerById(String id) {
            return "Customer[" + id + "]: Y. Vaishali Rao";
        }
    }

    static class CustomerService {
        private CustomerRepository repository;

        public CustomerService(CustomerRepository repository) {
            this.repository = repository;
        }

        public void showCustomer(String id) {
            System.out.println(repository.findCustomerById(id));
        }
    }

    public static void main(String[] args) {
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);

        service.showCustomer("C123");
    }
}
