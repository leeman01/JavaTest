package service;

import org.springframework.stereotype.Service;

import com.kdigital.project.Entity.AuthUserEntity;
import com.kdigital.project.Entity.ExportingExportEntity;
import com.kdigital.project.Entity.ManagingDocumentCertificateoriginEntity;
import com.kdigital.project.Entity.ManagingDocumentInvoiceEntity;
import com.kdigital.project.Entity.ManagingDocumentParentEntity;
import com.kdigital.project.Entity.OfEntity;
import com.kdigital.project.Entity.ScfiEntity;
import com.kdigital.project.repository.BookingShipmentPredictionScfiRepository;
import com.kdigital.project.repository.BookingShipmentPriceOfRepository;
import com.kdigital.project.repository.CoRepository;
import com.kdigital.project.repository.ExportRepository;
import com.kdigital.project.repository.ManagingDocumentInvoiceRepository;
import com.kdigital.project.repository.ManagingDocumentRepository;
import com.kdigital.project.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
public class UserService {
	private UserRepository a;
	private BookingShipmentPredictionScfiRepository c;
	private BookingShipmentPriceOfRepository d;
	private ManagingDocumentRepository e;
	private ManagingDocumentInvoiceRepository f;
	private ExportRepository aa;
	private CoRepository aaa;
	public void userDataSave(AuthUserEntity b) {
		
		a.save(b);
		
		
	}
	public void scfiDataSave(ScfiEntity b) {
		c.save(b);
	}
	
	public void ofDataSave(OfEntity b) {
		d.save(b);
	}
	public void documentSave(ManagingDocumentParentEntity b) {
		e.save(b);
	}
	public void invoiceSave(ManagingDocumentInvoiceEntity b) {
		f.save(b);
	}
	public void exportSave(ExportingExportEntity b) {
		aa.save(b);
	}
	public void exportSave1(ManagingDocumentCertificateoriginEntity b) {
		aaa.save(b);
	}
}
