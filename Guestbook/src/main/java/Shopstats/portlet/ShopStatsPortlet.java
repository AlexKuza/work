package Shopstats.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.io.ByteArrayFileInputStream;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StreamUtil;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import Shopstats.constants.ShopStatsPortletKeys;
import sbild.model.Electronics;
import sbild.model.EmpltopCnt;
import sbild.model.EmpltopSum;
import sbild.service.ElectroEmployeeLocalService;
import sbild.service.ElectroTypeLocalService;
import sbild.service.ElectronicsLocalService;
import sbild.service.EmployeeLocalService;
import sbild.service.EmpltopCntLocalService;
import sbild.service.EmpltopCntLocalServiceUtil;
import sbild.service.EmpltopSumLocalService;
import sbild.service.EmpltopSumLocalServiceUtil;
import sbild.service.PositionTypeLocalService;
import sbild.service.PurchaseLocalService;
import sbild.service.PurchaseTypeLocalService;


/**
 * @author Alex
 */
@Component(
	    immediate = true,
	    property = {
	      "com.liferay.portlet.display-category=category.social",
	      "com.liferay.portlet.instanceable=false",
	      "com.liferay.portlet.scopeable=true",
	      "javax.portlet.display-name=Shopstats",
	      "javax.portlet.expiration-cache=0",
	      "javax.portlet.init-param.template-path=/",
	      "javax.portlet.init-param.view-template=/shopstats/view.jsp",
	      "javax.portlet.resource-bundle=content.Language",
	      "javax.portlet.security-role-ref=power-user,user",
	      "javax.portlet.supports.mime-type=text/html",
	      "javax.portlet.name=" + ShopStatsPortletKeys.SHOPSTATS
	    },
	    service = Portlet.class
	)
public class ShopStatsPortlet extends MVCPortlet {
	
	public void addElectronics(ActionRequest request, ActionResponse response)
            throws PortalException {

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
        		Electronics.class.getName(), request);
        
        String name = ParamUtil.getString(request, "name");
        long etypeId = ParamUtil.getLong(request, "etypeId");
        long price = ParamUtil.getLong(request, "price");
        int count = ParamUtil.getInteger(request, "count");
        Boolean inStock = ParamUtil.getBoolean(request, "inStock");
        Boolean archive = ParamUtil.getBoolean(request, "archive");
        String description = ParamUtil.getString(request, "description");        
        long electrId = ParamUtil.getLong(request, "electrId");

    if (electrId > 0) {

        try {
            _electronicsLocalService.addElectronics(
                electrId, name, etypeId, price, count,
                inStock, archive, description, serviceContext);
        }
        catch (Exception e) {
            System.out.println(e);

            PortalUtil.copyRequestParameters(request, response);
        }

    }
    else {

        try {
            _electronicsLocalService.addElectronics(
            	electrId, name, etypeId, price, count,
                inStock, archive, description, serviceContext);
        }
        catch (Exception e) {
            System.out.println(e);

            PortalUtil.copyRequestParameters(request, response);
        }
    }

}
	
	public void deleteElectronics(ActionRequest request, ActionResponse response) throws PortalException {
        long electrId = ParamUtil.getLong(request, "electrId");
        long guestbookId = ParamUtil.getLong(request, "guestbookId");

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
            Electronics.class.getName(), request);

        try {

            //response.setRenderParameter(
                //"guestbookId", Long.toString(guestbookId));

            _electronicsLocalService.deleteElectronics(electrId);
        }

        catch (Exception e) {
            Logger.getLogger(ShopStatsPortlet.class.getName()).log(
                Level.SEVERE, null, e);
        }
}
	
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
	    throws IOException, PortletException {

	    getTops();


	    super.render(renderRequest, renderResponse);
	}
	
	
	public void getTopBySum() {

		_empltopSumLocalService.deleteEmplTopSums();
		
	    List<EmpltopSum> entr = EmpltopSumLocalServiceUtil.findTopBySum(0, 100);
	    //System.out.println(entr);
	    entr.forEach(number -> {
	    	String pos = number.getPosition();
            String lastname = number.getLastname();
            long sum = number.getSum();
            try {
				_empltopSumLocalService.addEmpltopSum(pos, lastname, sum);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    	}
	    );
	}
	
	public void getTopByCnt() {

		_empltopCntLocalService.deleteEmplTopCnts();
		
	    List<EmpltopCnt> entr = EmpltopCntLocalServiceUtil.findTopByCnt(0, 100);
	    
	    entr.forEach(number -> {
	    	String pos = number.getPosition();
            String lastname = number.getLastname();
            int count = number.getCount();
            try {
				_empltopCntLocalService.addEmpltopCnt(pos, lastname, count);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    	}
	    );
	    
	}
	
	
	public void getTops() {
		getTopBySum();
		getTopByCnt();
	}
	
	public void cleanRegisters() {
		_electronicsLocalService.deleteElectronics();
		
		_electroTypeLocalService.deleteElectroTypes();
		
		_employeeLocalService.deleteEmployees();
		
		_purchaseTypeLocalService.deletePurchaseTypes();
		
		_positionTypeLocalService.deletePositionTypes();
		
		_purchaseLocalService.deletePurchases();
		
		_electroEmployeeLocalService.deleteElectroEmployees();
	}


	public void unZip(File file, String out){
		 
		try {

             byte[] buffer = new byte[2048];

             Path outDir = Paths.get(out);

             FileInputStream fis = new FileInputStream(file);
              BufferedInputStream bis = new BufferedInputStream(fis);
              ZipInputStream stream = new ZipInputStream(bis);

              ZipEntry entry;
              while ((entry = stream.getNextEntry()) != null) {

                  Path filePath = outDir.resolve(entry.getName());
                  System.out.println(filePath);

                  try (FileOutputStream fos = new FileOutputStream(filePath.toFile());
                          BufferedOutputStream bos = new BufferedOutputStream(fos, buffer.length)) {

                      int len;
                      while ((len = stream.read(buffer)) > 0) {
                          bos.write(buffer, 0, len);
                          System.out.println(buffer);
                      }
                  }
              }
	             
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	}
	
	public void uploadFileAction(ActionRequest actionRequest,ActionResponse actionResponse){
		 
	       UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest); 
	       
	       cleanRegisters();
	       //System.out.println("Working Directory = " + System.getProperty("user.dir"));
	       
	       String outDir = System.getProperty("user.home")+"\\res\\";
	       System.out.println(outDir);

	       File directory = new File(outDir);
	       if (! directory.exists()){
	           directory.mkdir();
	           
	       }
	       
	         File file = uploadPortletRequest.getFile("sampleFile");
	         if (!file.exists()) {
	           System.out.println("Empty File");
	           return;
	         }
	         
	         unZip(file, outDir);
	         parseCsvs (outDir);

	}
	
	public void parseCsvs (String path) {
		Path outDir = Paths.get(path);
		Path filePath;
		filePath = outDir.resolve("Electronics.csv");
		parseElectronics (filePath.toString());
		
		filePath = outDir.resolve("ElectroType.csv");
		parseElectroType (filePath.toString());
		
		filePath = outDir.resolve("ElectroEmployee.csv");
		parseElectroEmployee (filePath.toString());
		
		filePath = outDir.resolve("Purchase.csv");
		parsePurchase (filePath.toString());
		
		filePath = outDir.resolve("PurchaseType.csv");
		parsePurchaseType (filePath.toString());
		
		filePath = outDir.resolve("PositionType.csv");
		parsePositionType (filePath.toString());
		
		filePath = outDir.resolve("Employee.csv");
		parseEmployee (filePath.toString());
	}
	
	
	public void parseElectronics (String csvFilePath) {
		
        String lineText = null;

        try {
        	BufferedReader lineReader = new BufferedReader(new InputStreamReader(new FileInputStream(csvFilePath), "windows-1251"));
        	
			lineReader.readLine();
			
			while ((lineText = lineReader.readLine()) != null) {
	            String[] data = lineText.split(";");
	            
	            String id = data[0];
	            String name = data[1];
	            String etype = data[2];
	            String price = data[3];
	            String countG = data[4];
	            String stock = data[5];
	            String archive = data[6];
	            String desc = data[7];

	            long lId = Long.parseLong(id);
	            long lEtype = Long.parseLong(etype);
	            long lPrice = Long.parseLong(price);
	            int lCount = Integer.parseInt(countG);
	            boolean lStock = "1".equals(stock);
	            boolean lArchive = "1".equals(archive);

				_electronicsLocalService.addElectronics(
					lId, name, lEtype, lPrice, lCount,
					lStock, lArchive, desc, null);
				
		}
			
			lineReader.close();
			
			
        }catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // skip header line
        catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
public void parseElectroType (String csvFilePath) {
		
        String lineText = null;

        int count = 0;

        try {
        	BufferedReader lineReader = new BufferedReader(new InputStreamReader(new FileInputStream(csvFilePath), "windows-1251"));
        	
			lineReader.readLine();
			
			while ((lineText = lineReader.readLine()) != null) {
	            String[] data = lineText.split(";");
	            
	            String id = data[0];
	            String name = data[1];

	            long lId = Long.parseLong(id);
	            

				_electroTypeLocalService.addElectroType(lId, name);
				
		}
			
			lineReader.close();
			
			
        }catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // skip header line
        catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void parseElectroEmployee (String csvFilePath) {
		
	    String lineText = null;
	
	    int count = 0;
	
	    try {
	    	BufferedReader lineReader = new BufferedReader(new InputStreamReader(new FileInputStream(csvFilePath), "windows-1251"));
	    	
			lineReader.readLine();
			
			while ((lineText = lineReader.readLine()) != null) {
	            String[] data = lineText.split(";");
	            
	            String id = data[0];
	            String id2 = data[1];

	
	            long emplId = Long.parseLong(id);
	            long etypeId = Long.parseLong(id2);

	
				_electroEmployeeLocalService.addElectroEmployee(emplId,etypeId);
				
		}
			
			lineReader.close();
			
			
	    }catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // skip header line
	    catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void parsePurchase (String csvFilePath) {
		
        String lineText = null;

        int count = 0;

        try {
        	BufferedReader lineReader = new BufferedReader(new InputStreamReader(new FileInputStream(csvFilePath), "windows-1251"));
        	
			lineReader.readLine();
			
			while ((lineText = lineReader.readLine()) != null) {
	            String[] data = lineText.split(";");
	            
	            String id = data[0];
	            String electrId = data[1];
	            String emplId = data[2];
	            String purchDate = data[3];
	            String type = data[4];

	            long lId = Long.parseLong(id);
	            long lelectrId = Long.parseLong(electrId);
	            long lemplId = Long.parseLong(emplId);
	            Date lpurchDate = new SimpleDateFormat("dd.MM.yyyy HH:mm").parse(purchDate);  
	            long ltype = Long.parseLong(type);
	            

				_purchaseLocalService.addPurchase(
					lId, lelectrId, lemplId, lpurchDate,
					ltype);
				
		}
			
			lineReader.close();
			
			
        }catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // skip header line
        catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void parsePurchaseType (String csvFilePath) {
		
        String lineText = null;

        int count = 0;

        try {
        	BufferedReader lineReader = new BufferedReader(new InputStreamReader(new FileInputStream(csvFilePath), "windows-1251"));
        	
			lineReader.readLine();
			
			while ((lineText = lineReader.readLine()) != null) {
	            String[] data = lineText.split(";");
	            
	            String id = data[0];
	            String name = data[1];

	            long lId = Long.parseLong(id);
	            

				_purchaseTypeLocalService.addPurchaseType(lId, name);
				
		}
			
			lineReader.close();
			
			
        }catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // skip header line
        catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void parsePositionType (String csvFilePath) {
		
        String lineText = null;

        int count = 0;

        try {
        	BufferedReader lineReader = new BufferedReader(new InputStreamReader(new FileInputStream(csvFilePath), "windows-1251"));
        	
			lineReader.readLine();
			
			while ((lineText = lineReader.readLine()) != null) {
	            String[] data = lineText.split(";");
	            
	            String id = data[0];
	            String name = data[1];

	            long lId = Long.parseLong(id);
	            

				_positionTypeLocalService.addPositionType(lId, name);
				
		}
			
			lineReader.close();
			
			
        }catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // skip header line
        catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void parseEmployee (String csvFilePath) {
		
        String lineText = null;

        int count = 0;

        try {
        	BufferedReader lineReader = new BufferedReader(new InputStreamReader(new FileInputStream(csvFilePath), "windows-1251"));
        	
			lineReader.readLine();
			
			while ((lineText = lineReader.readLine()) != null) {
	            String[] data = lineText.split(";");
	            
	            String id = data[0];
	            String lastname = data[1];
	            String firstname = data[2];
	            String patr = data[3];
	            String birth = data[4];
	            String pos = data[5];
	            String gen = data[6];

	            long lId = Long.parseLong(id);
	            Date lbirth =  new SimpleDateFormat("dd.MM.yyyy").parse(birth); 
	            long lpos = Long.parseLong(pos);
	            boolean lgen = "1".equals(gen);

				_employeeLocalService.addEmployee(
					lId, lastname, firstname, patr,
					lbirth, lpos, lgen);
				
		}
			
			lineReader.close();
			
			
        }catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // skip header line
        catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	
	@Reference
	private ElectronicsLocalService _electronicsLocalService;
	
	@Reference
	private ElectroTypeLocalService _electroTypeLocalService;
	
	@Reference
	private EmployeeLocalService _employeeLocalService;
	
	@Reference
	private PurchaseTypeLocalService _purchaseTypeLocalService;
	
	@Reference
	private PositionTypeLocalService _positionTypeLocalService;
	
	@Reference
	private PurchaseLocalService _purchaseLocalService;
	
	@Reference
	private ElectroEmployeeLocalService _electroEmployeeLocalService;
	
	@Reference
	private EmpltopSumLocalService _empltopSumLocalService;
	
	@Reference
	private EmpltopCntLocalService _empltopCntLocalService;

}