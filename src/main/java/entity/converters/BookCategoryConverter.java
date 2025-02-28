package entity.converters;

import entity.enums.BookCategory;
import jakarta.persistence.AttributeConverter;

public class BookCategoryConverter implements AttributeConverter<BookCategory, Integer> {
	@Override
	public Integer convertToDatabaseColumn(BookCategory attr) {
		if (attr == null) {
			return null;
		}
		switch (attr) {
			case CLASSICS:
				return 10;
			case SCI_FI:
				return 20;
			case LIFE_STYLE:
				return 30;
			case POLITICS:
				return 40;
			default:
				throw new IllegalArgumentException("Unsupported BookCategory: " + attr);
		}
	}

	@Override
	public BookCategory convertToEntityAttribute(Integer dbData) {
		if (dbData == null) {
			return null;
		}
		switch (dbData) {
			case 10:
				return BookCategory.CLASSICS;
			case 20:
				return BookCategory.SCI_FI;
			case 30:
				return BookCategory.LIFE_STYLE;
			case 40:
				return BookCategory.POLITICS;
			default:
				throw new IllegalArgumentException("Unsupported BookCategory: " + dbData);
		}
	}
}
