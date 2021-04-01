package org.dizitart.no2.transaction;

import org.dizitart.no2.collection.NitriteCollection;
import org.dizitart.no2.repository.ObjectRepository;

/**
 * Represents an ACID transaction on nitrite database.
 *
 * @author Anindya Chatterjee
 * @since 4.0
 */
public interface Transaction extends AutoCloseable {
    /**
     * Gets the transaction id.
     *
     * @return the id
     */
    String getId();

    /**
     * Gets the current state of the transaction.
     *
     * @return the state
     */
    State getState();

    /**
     * Gets a {@link NitriteCollection} to perform ACID operations on it.
     *
     * @param name the name
     * @return the collection
     */
    NitriteCollection getCollection(String name);

    /**
     * Gets an {@link ObjectRepository} to perform ACID operations on it.
     *
     * @param <T>  the type parameter
     * @param type the type
     * @return the repository
     */
    <T> ObjectRepository<T> getRepository(Class<T> type);

    /**
     * Gets an {@link ObjectRepository} to perform ACID operations on it.
     *
     * @param <T>  the type parameter
     * @param type the type
     * @param key  the key
     * @return the repository
     */
    <T> ObjectRepository<T> getRepository(Class<T> type, String key);

    /**
     * Completes the transaction and commits the data to the underlying store.
     */
    void commit();

    /**
     * Rolls back the changes.
     */
    void rollback();

    @Override
    void close();
}
