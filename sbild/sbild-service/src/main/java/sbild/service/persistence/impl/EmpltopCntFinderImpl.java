package sbild.service.persistence.impl;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import sbild.model.EmpltopCnt;
import sbild.model.impl.EmpltopCntImpl;
import sbild.service.persistence.EmpltopCntFinder;

@Component(service = EmpltopCntFinder.class)
public class EmpltopCntFinderImpl extends EmpltopCntFinderBaseImpl implements EmpltopCntFinder
{
	
	public List<EmpltopCnt> findTopByCnt(int begin, int end) {

		    Session session = null;
		    try {
		    	
		        session = openSession();

		        String sql = _customSQL.get(
		            getClass(),
		            FINDTOP_BY_CNT);
		        

		        SQLQuery q = session.createSQLQuery(sql);
		        q.setCacheable(false);
		        q.addEntity("GB_EmpltopCnt", EmpltopCntImpl.class);
		        

		        QueryPos qPos = QueryPos.getInstance(q);
		        

		        return (List<EmpltopCnt>) QueryUtil.list(q, getDialect(), begin, end);
		        
		    }
		    catch (Exception e) {
		        try {
		            throw new SystemException(e);
		        }
		        catch (SystemException se) {
		            se.printStackTrace();
		        }
		    }
		    finally {
		        closeSession(session);
		    }

		    return null;
		}

		public static final String FINDTOP_BY_CNT =
				EmpltopCntFinder.class.getName() +
		        ".findTopByCnt";

		@Reference
		private CustomSQL _customSQL;


}
