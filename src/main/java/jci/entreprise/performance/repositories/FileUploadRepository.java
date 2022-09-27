package jci.entreprise.performance.repositories;

import jci.entreprise.performance.entities.UploadedFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadRepository extends JpaRepository<UploadedFile,Long> {
}
