DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'p_type') THEN
CREATE TYPE p_type AS ENUM ('WORK', 'BREAK');
END IF;
END $$;


DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'p_status') THEN
CREATE TYPE p_status AS ENUM ('ABANDONED', 'COMPLETED', 'IN_PROGRESS', 'STOPPED');
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
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'p_duration') THEN
CREATE TYPE p_duration AS ENUM ('TWENTY', 'TWENTY_FIVE', 'THIRTY');
END IF;
END $$;

-- Table for PConfig
CREATE TABLE IF NOT EXISTS p_config (
                                        id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                        work_session_length INT NOT NULL,
                                        break_session_length INT NOT NULL,
                                        sessions_before_long_break INT NOT NULL,
                                        p_notification_type p_notification_type NOT NULL
);

-- Table for PSession
CREATE TABLE IF NOT EXISTS p_session (
                                         id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                         start_time TIMESTAMP NOT NULL,
                                         end_time TIMESTAMP NOT NULL,
                                         p_type p_type NOT NULL,
                                         p_status p_status NOT NULL,
                                         p_duration p_duration NOT NULL
);