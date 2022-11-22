
/* The best way to use the Spring Transactional annotation */

@Service
@Transactional(readOnly = true)
public class Userservice implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername (String username)
    throws UsernameNot FoundException {
    ...
    }

    @Transactional
    public void createUser (User user) {
    ...
    }
}

----------------------------------------------------------------------------------------------------------------------------
/* The loadUserByUsername uses a read-only transaction, and since we are using Hibernate, Spring performs
some read-only optimizations as well.

On the other hand, the createUser has to write to the database. Hence, it overrides the readonly attribute
value with the default setting given by the @Transactional annotation, which is readOnly=false, therefore making
the transaction read-write*/
----------------------------------------------------------------------------------------------------------------------------
