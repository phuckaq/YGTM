DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'type') THEN
CREATE TYPE type AS ENUM ('WORK', 'BREAK');
END IF;
END $$;


DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'status') THEN
CREATE TYPE status AS ENUM ('UNCOMPLETED', 'COMPLETED', 'IN_PROGRESS');
END IF;
END $$;


DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'notification_type') THEN
CREATE TYPE notification_type AS ENUM ('SOUND', 'POPUP', 'NONE');
END IF;
END $$;

DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'duration_work') THEN
CREATE TYPE duration_work AS ENUM ('TWENTY', 'TWENTY_FIVE', 'THIRTY');
END IF;
END $$;

DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'duration_break') THEN
CREATE TYPE duration_break AS ENUM ('FIVE', 'TEN');
END IF;
END $$;

DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'duration_after_sessions') THEN
CREATE TYPE duration_after_sessions AS ENUM ('TWO', 'THREE', 'FOUR');
END IF;
END $$;

-- Table for PConfig
CREATE TABLE IF NOT EXISTS p_config (
                                        id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                        duration_work duration_work NOT NULL,
                                        duration_break duration_break NOT NULL,
                                        duration_after_sessions duration_after_sessions NOT NULL,
                                        notification_type notification_type NOT NULL
);

-- Table for PSession
CREATE TABLE IF NOT EXISTS p_session (
                                         id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                         start_time TIMESTAMP NOT NULL,
                                         end_time TIMESTAMP NOT NULL,
                                         type type NOT NULL,
                                         status status NOT NULL,
                                         duration_work duration_work,
                                         duration_break duration_break
);

-- Insert default configurations
INSERT INTO p_config (duration_work, duration_break, duration_after_sessions, notification_type)
VALUES
    ('TWENTY_FIVE', 'FIVE', 'FOUR', 'SOUND')
    ON CONFLICT DO NOTHING;