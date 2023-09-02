package chapter_1.revision_notes.anonymousinnerclass;

public class AnonInner {
	abstract class SalesTodayOnly {
		abstract int dollarsOff();
	}
	SalesTodayOnly salesTodayOnly = new SalesTodayOnly() {
		int dollarsOff() { return 3; }
	};
}
