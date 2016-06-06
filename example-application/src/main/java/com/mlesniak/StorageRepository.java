package com.mlesniak;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Michael Lesniak (mlesniak@micromata.de)
 */
public interface StorageRepository extends CrudRepository<Element, Long> {
}
