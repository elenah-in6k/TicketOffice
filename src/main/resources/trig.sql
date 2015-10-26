CREATE TRIGGER countReservedPlace AFTER INSERT or update or delete  ON Ticket
FOR EACH ROW BEGIN
   INSERT INTO log Set msg = 'insert', row_id = NEW.id;
END;*