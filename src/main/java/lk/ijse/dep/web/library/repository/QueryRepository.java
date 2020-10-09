package lk.ijse.dep.web.library.repository;

import lk.ijse.dep.web.library.entity.CustomEntity;

import javax.sql.DataSource;
import java.util.List;

public interface QueryRepository {

    public void setDataSource(DataSource ds);

    public List<CustomEntity> getCustomEntityList();

}
