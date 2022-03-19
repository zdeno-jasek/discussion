package sk.posam.discussion.domain.objednavka;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

public class TerminObjednavky {

	private static final long CELY_DEN_SEKUND = 24L * 3600;
	private final LocalTime cas;
	private final Duration dlzka;
	
	public TerminObjednavky(LocalTime cas, Duration dlzka) {
		this.cas = cas;
		this.dlzka = dlzka;
		if ( dlzka.isNegative() ) {
			throw new RuntimeException( "Dlzka objednavky nemoze byt zaporna" );
		}
		
		if ( dlzka.getSeconds() >= CELY_DEN_SEKUND ) {
			throw new RuntimeException( "Dlzka objednavky nemoze presiahnut jeden den" );			
		}
		
		LocalTime koniecTerminu = cas.plus(dlzka);
		if ( koniecTerminu.getHour() < cas.getHour() ) {
			throw new RuntimeException( "Termin objednavky nesmie presahovat polnoc" );			
		}
	}

	public Duration getDlzka() {
		return dlzka;
	}
	
	public LocalTime getCas() {
		return cas;
	}
	
}
