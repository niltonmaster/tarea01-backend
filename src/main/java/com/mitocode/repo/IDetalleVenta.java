package com.mitocode.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.model.DetalleVenta;

public interface IDetalleVenta extends JpaRepository<DetalleVenta, Integer>{

	//Transaccional
		@Modifying
		@Query(value="UPDATE  detalle_venta SET id_producto=:idProducto, id_venta=:idVenta",nativeQuery=true)
		Integer registrar(@Param("idProducto") Integer idProducto, @Param("idVenta") Integer idVenta);
}

//
//@Transactional
//@Modifying
//@Query(value = "UPDATE Users u set EMAIL_VERIFICATION_STATUS =:emailVerificationStatus where u.USER_ID = :userId",
//        nativeQuery = true)
//void updateUser(@Param("emailVerificationStatus") boolean emailVerificationStatus, @Param("userId") String userId);
