DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'p_type') THEN
CREATE TYPE p_type AS ENUM ('WORK', 'BREAK');
END IF;
END $$;


DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'p_status') THEN
CREATE TYPE p_status AS ENUM ('UNCOMPLETED', 'COMPLETED', 'IN_PROGRESS');
END IF;
END $$;


DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'p_notification_type') THEN
CREATE TYPE p_notification_type AS ENUM ('SOUND', 'POPUP', 'NONE');
END IF;
END $$;

DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'p_duration_work') THEN
CREATE TYPE p_duration_work AS ENUM ('TWENTY', 'TWENTY_FIVE', 'THIRTY');
END IF;
END $$;

DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'p_duration_break') THEN
CREATE TYPE p_duration_break AS ENUM ('FIVE', 'TEN');
END IF;
END $$;

DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'p_duration_after_sessions') THEN
CREATE TYPE p_duration_after_sessions AS ENUM ('TWO', 'THREE', 'FOUR');
END IF;
END $$;

-- Table for PConfig
CREATE TABLE IF NOT EXISTS p_config (
                                        id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                        p_duration_work p_duration_work NOT NULL,
                                        p_duration_break p_duration_break NOT NULL,
                                        p_duration_after_sessions p_duration_after_sessions NOT NULL,
                                        p_notification_type p_notification_type NOT NULL
);

-- Table for PSession
CREATE TABLE IF NOT EXISTS p_session (
                                         id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                         start_time TIMESTAMP NOT NULL,
                                         end_time TIMESTAMP NOT NULL,
                                         p_type p_type NOT NULL,
                                         p_status p_status NOT NULL,
                                         p_duration_work p_duration_work,
                                         p_duration_break p_duration_break
);

-- Insert default configurations
INSERT INTO p_config (p_duration_work, p_duration_break, p_duration_after_sessions, p_notification_type)
VALUES
    ('TWENTY_FIVE', 'FIVE', 'FOUR', 'SOUND')
    ON CONFLICT DO NOTHING;