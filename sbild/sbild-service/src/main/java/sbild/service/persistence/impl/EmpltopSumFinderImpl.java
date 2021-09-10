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

import sbild.model.EmpltopSum;
import sbild.model.impl.EmpltopSumImpl;
import sbild.service.persistence.EmpltopSumFinder;

@Component(service = EmpltopSumFinder.class)
public class EmpltopSumFinderImpl extends EmpltopSumFinderBaseImpl implements EmpltopSumFinder
{
	
	public List<EmpltopSum> findTopBySum(int begin, int end) {

		    Session session = null;
		    try {
		    	
		        session = openSession();

		        String sql = _customSQL.get(
		            getClass(),
		            FINDTOP_BY_SUM);
		        

		        SQLQuery q = session.createSQLQuery(sql);
		        q.setCacheable(false);
		        q.addEntity("GB_EmpltopSum", EmpltopSumImpl.class);
		        

		        QueryPos qPos = QueryPos.getInstance(q);
		        

		        return (List<EmpltopSum>) QueryUtil.list(q, getDialect(), begin, end);
		        
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

		public static final String FINDTOP_BY_SUM =
				EmpltopSumFinder.class.getName() +
		        ".findTopBySum";

		@Reference
		private CustomSQL _customSQL;


}
