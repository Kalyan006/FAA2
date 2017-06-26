package com.phm.hec.calendar;

import java.util.Calendar;

public class DatePicker {
	private final Calendar calendar;

	public DatePicker(Calendar calendar) {
		this.calendar = calendar;
	}

	public void pick(Enum month, int day, int year) {
		calendar.show();
		calendar.enterYear(year);
		calendar.enterMonth(month);
		calendar.pickDay(day);
	}

	public interface Calendar {

		void show();

		void nextYear();

		void nextMonth();

		void previousMonth();

		void previousYear();

		void enterYear(int year);

		void enterMonth(Enum month);

		void pickDay(int day);

		int currentYear();

		int currentMonth();
	}

	public class FlippingMethod {

		private final Calendar calendar;

		public FlippingMethod(Calendar calendar) {
			this.calendar = calendar;
		}

		public void flipToYear(int year) {
			int yearDiffrence = calendar.currentYear() - year;
			if (yearDiffrence < 0) {
				for (int i = yearDiffrence; i < 0; i++) {
					calendar.nextYear();
				}
			} else if (yearDiffrence > 0) {
				for (int i = 0; i < yearDiffrence; i++) {
					calendar.previousYear();
				}
			}
		}

		public void flipToMonth(Enum month) {
			int monthDifference = calendar.currentMonth() - month.ordinal();
			if (monthDifference < 0) {
				for (int i = monthDifference; i < 0; i++) {
					calendar.nextMonth();
				}
			} else if (monthDifference > 0) {
				for (int i = 0; i < monthDifference; i++) {
					calendar.previousMonth();
				}
			}
		}

	}

}
