package br.com.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import br.com.wallet.entity.WalletItem;
import br.com.wallet.util.enums.TypeEnum;

public interface WalletItemRepository extends JpaRepository<WalletItem, Long> {

	Page<WalletItem> findAllByWalletIdAndDateGreaterThanEqualAndDateLessThanEqual(Long wallet, Date init, Date end,
			Pageable page);

	List<WalletItem> findByWalletIdAndType(Long wallet, TypeEnum type);

	@Query(value = "select sum(value) from WalletItem wi where wi.wallet.id = :wallet")
	BigDecimal sumByWalletId(@Param("wallet") Long wallet);
}
